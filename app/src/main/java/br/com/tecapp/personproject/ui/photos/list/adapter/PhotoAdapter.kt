package br.com.tecapp.personproject.ui.photos.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.tecapp.personproject.databinding.PhotoItemBinding
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel

class PhotoAdapter(var photos: List<PhotoViewModel>, private val listenner: PhotoAdapterListenner) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: PhotoItemBinding = PhotoItemBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding, listenner)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class PhotoViewHolder(private val binding: PhotoItemBinding, private val listenner: PhotoAdapterListenner) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photoViewModel: PhotoViewModel) {
            binding.viewModel = photoViewModel

            binding.tvAuthorUrl.setOnClickListener {
                listenner.openUrlAuthor(photoViewModel.authorUrl)
            }

            binding.clContent.setOnClickListener {
                listenner.openDetail(photoViewModel)
            }

            binding.executePendingBindings()
        }

    }

}