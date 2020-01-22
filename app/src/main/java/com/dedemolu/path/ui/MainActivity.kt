package com.dedemolu.path.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.dedemolu.path.R
import com.dedemolu.path.data.model.GridMenu
import com.dedemolu.path.utils.RetriviedData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager = GridLayoutManager(this, 2)

        val menus: List<GridMenu> = listOf(
            GridMenu(1,"Books"),
            GridMenu(2,"Search"),
            GridMenu(3,"Points"),
            GridMenu(4,"About"),
            GridMenu(5,"Help")
        )


        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == menus.lastIndex) {
                    return if (menus.size % 2 == 0) 1 else 2
                }
                return 1
            }
        }

        RetriviedData.dataBooksFromJson(assets.open("books.json"));

        val menuAdapter = MenuAdapter(menus)

        menu_list.layoutManager = manager
        menu_list.adapter = menuAdapter
        menuAdapter.onItemClicked = {
            Toast.makeText(this, it.title, Toast.LENGTH_LONG).show()
        }
    }
}
