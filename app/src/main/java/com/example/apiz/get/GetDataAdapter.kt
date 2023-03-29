package com.example.apiz.get

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiz.MainActivity
import com.example.apiz.R

class GetDataAdapter(
    private val context: Context,
    private val dataList: ArrayList<PostItem>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //   inflating the layout format so as to use it
        val layoutFormat = LayoutInflater.from(parent.context).inflate(R.layout.rv_custom_layout, parent, false)
        return MyViewHolder(layoutFormat)
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentData = dataList[position]

        if (holder is MyViewHolder) {
//            GlideLoader(context).loadProductPicture( currentData.image,
//                holder.itemView.recycler_productImage
//            )


            holder.userId.text = currentData.user_id
            holder.postId.text  = currentData.id
            holder.postTitle.text = currentData.title
            holder.postBody.text = currentData.body


            // Setting the item click for each item in the recyclerview

            holder.itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
//                intent.putExtra(Constants.PRODUCT_EXTRA_ID, currentProduct.product_id)
//                intent.putExtra(Constants.PRODUCT_EXTRA_OWNER_ID, currentProduct.user_id)
                context.startActivity(intent)
            }
        }
    }



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userId = itemView.findViewById<TextView>(R.id.userid)!!
        val postId = itemView.findViewById<TextView>(R.id.post_id)!!
        val postTitle = itemView.findViewById<TextView>(R.id.post_title)!!
        val postBody = itemView.findViewById<TextView>(R.id.post_body)!!
    }

}