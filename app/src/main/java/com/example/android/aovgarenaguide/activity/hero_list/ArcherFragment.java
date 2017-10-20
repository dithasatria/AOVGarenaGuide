package com.example.android.aovgarenaguide.activity.hero_list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.aovgarenaguide.R;
import com.example.android.aovgarenaguide.adapter.HeroListAdapter;
import com.example.android.aovgarenaguide.model.select_hero.APIResponseSelectHero;
import com.example.android.aovgarenaguide.model.select_hero.ResultItem;
import com.example.android.aovgarenaguide.rest.APIClient;
import com.example.android.aovgarenaguide.rest.APIService;
import com.example.android.aovgarenaguide.util.Utility;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArcherFragment extends Fragment {

    @BindView(R.id.rvAllHeroList) RecyclerView RV_HERO_LIST;
    @BindView(R.id.swiperefresh) SwipeRefreshLayout SWIPE_REFRESH;

    HeroListAdapter adapter;
    private List<ResultItem> items = new ArrayList<>();

    public ArcherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_all_hero, container, false);
        ButterKnife.bind(this, v);

        int mNoOfColumns = Utility.calculateNoOfColumns(getActivity());
        RV_HERO_LIST.setLayoutManager(new GridLayoutManager(getActivity(), mNoOfColumns));

        adapter = new HeroListAdapter(items, getActivity());
        RV_HERO_LIST.setAdapter(adapter);

        getDataHero();

        SWIPE_REFRESH.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataHero();
            }
        });

        return v;
    }

    private void getDataHero(){
        APIService apiService = APIClient.getRetrofitClient().create(APIService.class);
        final Call<APIResponseSelectHero> apiResponseCall = apiService.getSelectionHeroList(Utility.KEY_ARCHER);

        apiResponseCall.enqueue(new Callback<APIResponseSelectHero>() {
            @Override
            public void onResponse(Call<APIResponseSelectHero> call, Response<APIResponseSelectHero> response) {
                APIResponseSelectHero apiResponse = response.body();
                if(apiResponse != null){
                    items = apiResponse.getResult();
                    adapter.setData(items);
                }
                Log.d("Now Playing data: ", items.toString());
                Log.d("Now Playing cek link: ", apiResponseCall.toString());
                SWIPE_REFRESH.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<APIResponseSelectHero> call, Throwable t) {
                SWIPE_REFRESH.setRefreshing(false);
                Toast.makeText(getActivity(), "Parsing Gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
