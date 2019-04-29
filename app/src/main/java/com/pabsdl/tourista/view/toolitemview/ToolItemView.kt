package com.pabsdl.tourista.view.toolitemview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.pabsdl.tourista.R
import com.pabsdl.tourista.utils.clickWithGuard
import kotlinx.android.synthetic.main.view_tool_item.view.*

class ToolItemView(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs) {

    private var mClickAction: (() -> Unit)? = null

    init {
        View.inflate(context, R.layout.view_tool_item, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ToolItemView)
        val label = attributes.getString(R.styleable.ToolItemView_buttonText)
        val image = attributes.getDrawable(R.styleable.ToolItemView_srcImage)
        attributes.recycle()

        toolItemLabel.text = label
        toolItemImageButton.setImageDrawable(image)
        toolItemImageButton.clickWithGuard {
            mClickAction?.invoke()
        }
    }

    fun setClickAction(action: (() -> Unit)?) {
        mClickAction = action
    }
}