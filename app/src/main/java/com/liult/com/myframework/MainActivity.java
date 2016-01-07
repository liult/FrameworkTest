package com.liult.com.myframework;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liult.com.myframework.base.FragmentGroupActivity;
import com.liult.com.myframework.fragment.HomeFragment;
import com.liult.com.myframework.fragment.KindFragment;
import com.liult.com.myframework.fragment.MineFragment;
import com.liult.com.myframework.fragment.OrderFragment;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentGroupActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fragment_stub)
    FrameLayout fragmentStub;
    @Bind(R.id.tab_home)
    ImageButton tabHome;
    @Bind(R.id.tab_kind)
    ImageButton tabKind;
    @Bind(R.id.tab_order)
    ImageButton tabOrder;
    @Bind(R.id.tab_mine)
    ImageButton tabMine;
    @Bind(R.id.tab_menu)
    LinearLayout tabMenu;
//    @Bind(R.id.nav_view)
//    NavigationView navView;
//    @Bind(R.id.drawer_layout)
//    DrawerLayout drawerLayout;

    public static final int TAB_KIND = R.id.tab_home;
    public static final int TAB_HOME = R.id.tab_kind;
    public static final int TAB_ORDER = R.id.tab_order;
    public static final int TAB_MINE = R.id.tab_mine;
    private int mLastCheckTab = TAB_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        switchTab(TAB_HOME);
    }

    @OnClick({R.id.tab_home, R.id.tab_kind, R.id.tab_order, R.id.tab_mine})
    void onTabClick(View view){
        switch (view.getId()){
            case R.id.tab_home:
                switchTab(TAB_HOME);
                break;
            case R.id.tab_kind:
                switchTab(TAB_KIND);
                break;
            case R.id.tab_mine:
                switchTab(TAB_MINE);
                break;
            case R.id.tab_order:
                switchTab(TAB_ORDER);
            default:
                break;
        }
    }

    public void switchTab(int index) {
        mLastCheckTab = index;
        setDefaultDrawable();
        switch (index) {
            case TAB_HOME:
                tabHome.setImageResource(R.drawable.tab_home_selected);
                break;
            case TAB_KIND:
                tabKind.setImageResource(R.drawable.tab_kind_selected);
                break;
            case TAB_ORDER:
                tabOrder.setImageResource(R.drawable.tab_order_selected);
                break;
            case TAB_MINE:
                tabMine.setImageResource(R.drawable.tab_mine_elected);
                break;
        }
        switchPrimaryFragment(index);
    }

    public void setDefaultDrawable() {
        tabHome.setImageResource(R.drawable.tab_home_unselected);
        tabKind.setImageResource(R.drawable.tab_kind_unselected);
        tabOrder.setImageResource(R.drawable.tab_order_unselected);
        tabMine.setImageResource(R.drawable.tab_mine_unselected);
    }

    @Override
    protected void initPrimaryFragment() {

    }

    @Override
    protected Class<? extends Fragment> getPrimaryFragmentClass(int fragmentId) {
        Class<? extends Fragment> clazz;
        switch (fragmentId) {
            case TAB_HOME:
                clazz = HomeFragment.class;
                break;
            case TAB_KIND:
                clazz = KindFragment.class;
                break;
            case TAB_ORDER:
                clazz = OrderFragment.class;
                break;
            case TAB_MINE:
                clazz = MineFragment.class;
                break;
            default:
                clazz = MineFragment.class;
        }
        return clazz;
    }

    @Override
    protected Bundle getPrimaryFragmentArguments(int fragmentId) {
        return null;
    }

    @Override
    protected int getPrimaryFragmentStubId(int fragmentId) {
        return R.id.fragment_stub;
    }


//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
