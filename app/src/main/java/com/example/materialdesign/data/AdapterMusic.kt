package com.example.materialdesign.data

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.materialdesign.R
import com.example.materialdesign.inflate

class AdapterMusic : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var albumList = emptyList<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MusicHolder(
            parent.inflate(R.layout.card)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MusicHolder -> {
                val album = albumList[position]
                holder.bind(album)
            }
        }
    }

    override fun getItemCount(): Int = albumList.size


    abstract class BaseHolder(
        private val containerView: View
    ) : RecyclerView.ViewHolder(containerView) {

        private val imageAlbum: ImageView = itemView.findViewById(R.id.imageAlbum)
        private val titleAlbum: TextView = itemView.findViewById(R.id.titleAlbum)
        private val yearAlbum: TextView = itemView.findViewById(R.id.yearAlbum)

        protected fun bindMainInfo(
            image: Int,
            title: String,
            year: String
        ) {
            titleAlbum.text = title
            yearAlbum.text = year

            Glide.with(itemView)
                .load(image)
                .placeholder(R.drawable.ic_preview)
                .into(imageAlbum)
        }
    }

    class MusicHolder(
        containerView: View
    ) : BaseHolder(containerView) {
        fun bind(album: ItemData) {
            bindMainInfo(album.image, album.title, album.year)
        }
    }
}