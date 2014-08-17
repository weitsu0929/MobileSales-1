package com.abc.model;

import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abc.drawer_fragment.People;
import com.abc.drawer_fragment.ClientNote;
import com.abc.drawer_fragment.Calender;
import com.abc.drawer_fragment.Recent;
import com.abc.drawer_fragment.Search;
import com.abc.drawer_fragment.Schedule;
import com.abc.drawer_fragment.Others;
import com.abc.model.R;

public class MainActivity extends FragmentActivity {
	private DrawerLayout my_DrawerLayout;
	private ListView my_DrawerList;
	private ActionBarDrawerToggle my_DrawerToggle;

	private CharSequence my_DrawerTitle;
	private CharSequence my_Title;
	private String[] my_PlanetTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		my_Title = my_DrawerTitle = getTitle();
		my_PlanetTitles = getResources().getStringArray(R.array.planets_array);
		my_DrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		my_DrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		my_DrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// set up the drawer's list view with items and click listener
		my_DrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, my_PlanetTitles));
		my_DrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		my_DrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		my_DrawerLayout, /* DrawerLayout object */
		R.drawable.drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(my_Title);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(my_DrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		my_DrawerLayout.setDrawerListener(my_DrawerToggle);

		if (savedInstanceState == null) {
			selectItem(0);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		boolean drawerOpen = my_DrawerLayout.isDrawerOpen(my_DrawerList);
		menu.findItem(R.id.action_notice).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (my_DrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action buttons
		switch (item.getItemId()) {
		// case R.id.action_websearch:
		// // create intent to perform web search for this planet
		// Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
		// intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
		// // catch event that there's no activity to handle intent
		// if (intent.resolveActivity(getPackageManager()) != null) {
		// startActivity(intent);
		// } else {
		// Toast.makeText(this, R.string.app_not_available,
		// Toast.LENGTH_LONG).show();
		// }
		// return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments

		FragmentManager fragmentManager = getFragmentManager();
		FragmentManager fm = getFragmentManager();
		android.support.v4.app.FragmentManager fragmentManager7 = getSupportFragmentManager();
		People people = new People();
		ClientNote clientNote = new ClientNote();
		Calender calender = new Calender();
		Recent recent = new Recent();
		Search search = new Search();
		Schedule schedule = new Schedule();
		Others others = new Others();

		switch (position) {
		case 0:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, people).commit();
				}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, people).commit();
			}
			break;
			
		case 1:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, clientNote).commit();
			}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, clientNote).commit();
			}
			break;
		case 2:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, calender).commit();
			}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, calender).commit();
			}
			break;
		case 3:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, recent).commit();
			}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, recent).commit();
			}
			break;
		case 4:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, search).commit();
			}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, search).commit();
			}
			break;
		case 5:
			if(fragmentManager7.findFragmentById(R.id.content_frame)==null){
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, schedule).commit();
			}
			else {
				fragmentManager7.beginTransaction()
				.remove(fragmentManager7.findFragmentById(R.id.content_frame)).commit();
				fragmentManager.beginTransaction()
				.replace(R.id.content_frame, schedule).commit();
			}
			break;
		case 6:
			// special case
			
			fm.beginTransaction()
					.remove(fm.findFragmentById(R.id.content_frame)).commit();

			fragmentManager7.beginTransaction()
					.replace(R.id.content_frame, others).commit();

			break;
		default:

			return;

		}

		my_DrawerList.setItemChecked(position, true);
		setTitle(my_PlanetTitles[position]);
		my_DrawerLayout.closeDrawer(my_DrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		my_Title = title;
		getActionBar().setTitle(my_Title);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		my_DrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		my_DrawerToggle.onConfigurationChanged(newConfig);
	}
}