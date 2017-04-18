package org.ocs.android.agent.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import org.ocs.android.actions.Inventory;
import org.ocs.android.agent.ExpandableSectionAdapter;
import org.ocs.android.agent.R;

/**
 * Display inventory to the user
 */
public class OCSShowInventory extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actvity_show_inventory);

        // Get the listview
        ExpandableListView maListView = (ExpandableListView) findViewById(R.id.myListView);

        // Set datas
        ExpandableListAdapter monListAdapter = new ExpandableSectionAdapter(this, Inventory.getInstance(this).getAllSections());

        // Set list adapter
        maListView.setAdapter(monListAdapter);
    }
}
