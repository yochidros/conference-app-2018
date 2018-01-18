package io.github.droidkaigi.confsched2018.presentation.common.binding

import android.databinding.BindingAdapter
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.view.View

@BindingAdapter("layout_constraintDimensionRatio")
fun View.layout_constraintDimensionRatio(newDimensionRatio: String) {
    val id = id.takeIf { it != View.NO_ID } ?: let {
        return
    }

    val parent = parent as? ConstraintLayout ?: let {
        return
    }

    val lp = layoutParams as? ConstraintLayout.LayoutParams ?: let {
        return
    }

    if (newDimensionRatio == lp.dimensionRatio) {
        return
    }

    ConstraintSet().apply {
        clone(parent)
        setDimensionRatio(id, newDimensionRatio)
    }.applyTo(parent)
}
