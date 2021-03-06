/*
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xfinity.rmvp.view

import android.support.v7.widget.RecyclerView
import com.xfinity.rmvp.presenter.ComponentPresenter

interface ComponentViewBinder<in T : RecyclerView.ViewHolder> {
    fun bind(componentPresenter: ComponentPresenter, componentView: ComponentView<out T>, viewHolder: T, position: Int)
}

class ClickableComponentViewBinder : ComponentViewBinder<RecyclerView.ViewHolder> {
    override fun bind(componentPresenter: ComponentPresenter,
                      componentView: ComponentView<out RecyclerView.ViewHolder>,
                      viewHolder: RecyclerView.ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener { componentPresenter.onComponentClicked(componentView, position) }
    }
}