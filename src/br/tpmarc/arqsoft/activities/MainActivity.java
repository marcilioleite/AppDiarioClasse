package br.tpmarc.arqsoft.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setTitle(R.string.app_name);
		
		Fragment fragmentTurmas = new TurmasActivity();
		Fragment fragmentAulas  = new AulasActivity();
		Fragment fragmentAlunos = new AlunosActivity();
		Fragment fragmentCursos = new CursosActivity();
		
		ActionBar.Tab tabTurmas = actionBar.newTab().setIcon(R.drawable.ic_action_group);
		ActionBar.Tab tabAulas  = actionBar.newTab().setIcon(R.drawable.ic_action_time);
		ActionBar.Tab tabAlunos = actionBar.newTab().setIcon(R.drawable.ic_action_person);
		ActionBar.Tab tabCursos = actionBar.newTab().setIcon(R.drawable.ic_action_labels);
		
		tabTurmas.setTabListener(new SherlockTabListener(fragmentTurmas));
		tabAulas .setTabListener(new SherlockTabListener(fragmentAulas));
		tabAlunos.setTabListener(new SherlockTabListener(fragmentAlunos));
		tabCursos.setTabListener(new SherlockTabListener(fragmentCursos));
		
		actionBar.addTab(tabTurmas);
		actionBar.addTab(tabAulas, true);
		actionBar.addTab(tabAlunos);
		actionBar.addTab(tabCursos);
	}
	
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {

        menu.add("Nova chamada")
        .setIcon(R.drawable.ic_action_new_event)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		
        menu.add("Configurações")
        .setIcon(R.drawable.ic_action_settings)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		
		return super.onCreateOptionsMenu(menu);
	}

}
