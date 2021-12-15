package com.example.appsell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> mListProduct;

    private IClickTocartListener iClickTocartListener;

    public interface IClickTocartListener{
        void onClickAddToCart(ImageView imgAddToCart, Product product);
    }

    public void setData(List<Product> list, IClickTocartListener listener){
        this.mListProduct = list;
        this.iClickTocartListener = listener;
        notifyDataSetChanged();

    }



    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);
        if(product == null){
            return;
        }
        holder.imgProduct.setImageResource(product.getResourceID());
        holder.tv_Product.setText(product.getName());
        holder.tv_Description.setText(product.getDescription());

        if(product.isAddToCart()){
            holder.imgAddToCart.setBackgroundResource(R.drawable.bg_gray_corner_11);
        }
        else holder.imgAddToCart.setBackgroundResource(R.drawable.bg_red_corner_11);

        holder.imgAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!product.isAddToCart()){
                    iClickTocartListener.onClickAddToCart(holder.imgAddToCart, product);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if(mListProduct != null){
            return  mListProduct.size();

        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgProduct;
        private TextView tv_Product, tv_Description;
        private ImageView imgAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mapping();

        }

        private void mapping() {
            imgProduct = itemView.findViewById(R.id.imgChanGaXaTac);
            tv_Product = itemView.findViewById(R.id.tv_ChanGaXaTac);
            tv_Description = itemView.findViewById(R.id.tv_Description);
            imgAddToCart = itemView.findViewById(R.id.img_add_to_cart);
        }
    }
}
