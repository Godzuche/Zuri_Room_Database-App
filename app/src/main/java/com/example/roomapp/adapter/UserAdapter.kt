package com.example.roomapp.adapter

//
//class NoteAdapter: ListAdapter<NoteEntity, NoteAdapter.NoteViewHolder>(NoteDiffUtil()) {
//
//    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        fun bind(item: NoteEntity) {
//            val noteTitle = itemView.findViewById<TextView>(R.id.note_title)
//            val noteDescription = itemView.findViewById<TextView>(R.id.note_description)
//
//            noteTitle.text = item.email
//            noteDescription.text = item.password
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.note_rv_item, parent
//        , false)
//        return NoteViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//}
//
//class NoteDiffUtil: DiffUtil.ItemCallback<NoteEntity>(){
//    override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
//        return oldItem.email == newItem.email
//    }
//
//}