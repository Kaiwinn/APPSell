package com.example.appsell;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment {

    private RecyclerView rcv_Product;
    private View mView;
    private MainActivity mainActivity;

    private ProductAdapter productAdapter;



    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_product, container, false);
        mainActivity = (MainActivity) getActivity();
        rcv_Product = mView.findViewById(R.id.rcv_product);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
        rcv_Product.setLayoutManager(linearLayoutManager);
        
        productAdapter = new ProductAdapter();
        productAdapter.setData(getListProduct(), new ProductAdapter.IClickTocartListener() {
            @Override
            public void onClickAddToCart(ImageView imgAddToCart, Product product) {
                AnimationUtil.translateAnimation(mainActivity.getVimgAnimation(), imgAddToCart, mainActivity.getViewEndAnimation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        product.setAddToCart(true);
                        imgAddToCart.setBackgroundResource(R.drawable.bg_gray_corner_11);
                        productAdapter.notifyDataSetChanged();

                        mainActivity.setCountProductInCart(mainActivity.getmCountProduct()+1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        rcv_Product.setAdapter(productAdapter);
        
        return mView;
    }

    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.changaxatac, "Chân gà xã comfort", "150k"));
        list.add(new Product(R.drawable.cuttlonn, "C*t lộn xào me", "80k"));
        list.add(new Product(R.drawable.thitkhoo, "Thịt kho cháy hết", "160k"));
        list.add(new Product(R.drawable.timheo, "Tim Crush \n(Tim heo)", "180k"));
        list.add(new Product(R.drawable.boxaohanh, "Bò gặm củ hành", "200k"));
        list.add(new Product(R.drawable.bochienxu, "Bò khoác áo len", "210k"));

        return list;
    }
}