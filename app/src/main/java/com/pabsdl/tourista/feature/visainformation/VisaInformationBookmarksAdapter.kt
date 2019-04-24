package com.pabsdl.tourista.feature.visainformation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pabsdl.tourista.R
import com.pabsdl.tourista.data.entities.VisaBookmark
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.item_visa_bookmark.view.*

class VisaInformationBookmarksAdapter(inflater: LayoutInflater,
                                      bookmarkClickedAction: (VisaBookmark) -> Unit,
                                      longPressedAction: (VisaBookmark) -> Unit) :
    RecyclerView.Adapter<VisaInformationBookmarksAdapter.ViewHolder>() {

    private val mInflater = inflater
    private val mClickedAction = bookmarkClickedAction
    private val mLongPressedAction = longPressedAction
    private var mBookmarks: List<VisaBookmark>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_visa_bookmark, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mBookmarks == null) return 0
        return mBookmarks!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookmark = mBookmarks?.get(position)
        holder.getTitleTextView().text = bookmark?.title
        holder.getUrlTextView().text = bookmark?.url
        holder.setOnClickListener { mClickedAction(bookmark!!) }
        holder.setOnLongPressListener { mLongPressedAction(bookmark!!) }
    }

    fun setBookmarks(bookmarks: List<VisaBookmark>) {
        mBookmarks = bookmarks
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val mView = view

        fun getTitleTextView() = mView.visaBookmarkTitleText!!

        fun getUrlTextView() = mView.visaBookmarkUrlText!!

        fun setOnClickListener(l: () -> Unit) {
            mView.clickWithGuard(action = l)
        }

        fun setOnLongPressListener(l: () -> Unit) {
            mView.setOnLongClickListener {
                l()
                true
            }
        }

    }
}