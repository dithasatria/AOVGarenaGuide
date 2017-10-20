package com.example.android.aovgarenaguide.activity.detail_hero;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.aovgarenaguide.R;
import com.example.android.aovgarenaguide.activity.hero_list.TankFragment;
import com.example.android.aovgarenaguide.activity.hero_list.WarriorFragment;
import com.example.android.aovgarenaguide.model.select_hero.ResultItem;
import com.example.android.aovgarenaguide.model.select_hero.detail_hero.APIResponseDetailHero;
import com.example.android.aovgarenaguide.rest.APIClient;
import com.example.android.aovgarenaguide.rest.APIService;
import com.example.android.aovgarenaguide.util.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailHeroActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ResultItem item;

    private int id_hero;

    @BindView(R.id.imgBackdrop) ImageView IMG_BACKDROP;
    @BindView(R.id.nestedScrollView) NestedScrollView NESTED_SCROLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        item = getIntent().getParcelableExtra(Utility.KEY_INTENT_HERO_DETAIL);

        id_hero = Integer.parseInt(item.getIdHero());

        getSupportActionBar().setTitle(item.getHeroName());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container2);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs2);
        tabLayout.setupWithViewPager(mViewPager);

        NESTED_SCROLL.setFillViewport (true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();
    }

    private void getData(){
        APIService apiService = APIClient.getRetrofitClient().create(APIService.class);
        final Call<APIResponseDetailHero> apiResponseCall = apiService.getHeroDetail(id_hero);

        apiResponseCall.enqueue(new Callback<APIResponseDetailHero>() {
            @Override
            public void onResponse(Call<APIResponseDetailHero> call, Response<APIResponseDetailHero> response) {
                APIResponseDetailHero apiResponse = response.body();
                if(apiResponse != null){
                    Glide.with(DetailHeroActivity.this).load(Utility.URL_IMG_HERO + item.getRoleHero() +"/" + apiResponse.getResult().get(0).getImgBackdrop()).into(IMG_BACKDROP);

                    Toast.makeText(DetailHeroActivity.this, apiResponse.getResult().get(0).getInitialHero(), Toast.LENGTH_SHORT).show();
                }
                Log.d("data hero: ", apiResponse.getResult().toString());
            }

            @Override
            public void onFailure(Call<APIResponseDetailHero> call, Throwable t) {
                Toast.makeText(DetailHeroActivity.this, "Parsing Gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hero_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    RingkasanFragment tab1 = new RingkasanFragment();
                    return tab1;
                case 1:
                    TankFragment tab2 = new TankFragment();
                    return tab2;
                case 2:
                    WarriorFragment tab3 = new WarriorFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "RINGKASAN";
                case 1:
                    return "BUILD";
                case 2:
                    return "KOMENTAR";
            }
            return null;
        }
    }
}
