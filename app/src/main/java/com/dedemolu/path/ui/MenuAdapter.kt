package com.dedemolu.path.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dedemolu.path.R
import com.dedemolu.path.data.model.Book
import com.dedemolu.path.data.model.GridMenu

class MenuAdapter(
    val menus: List<GridMenu>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    var onItemClicked: (menu: GridMenu) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_card_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount() = menus.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.menuName.text = menus[position].title
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var menuName: TextView
        private lateinit var book: Book

        init {
            menuName = itemView.findViewById(R.id.menu_txt)

            itemView.setOnClickListener {
                onItemClicked.invoke(menus[adapterPosition])
            }

        }
    }
}