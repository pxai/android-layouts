package io.pello.android.layoutsamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MainActivity for layout samples
 */
public class MainActivity extends AppCompatActivity {

    private ListView layoutListView;
    private ArrayAdapter<String> layoutListAdapter;
    private String[] layoutItems = {
            "FrameLayout",
            "LinearLayoutHorizontal",
            "LinearLayoutVertical",
            "TableLayout",
            "GridLayout",
            "RelativeLayout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutListView = (ListView) findViewById(R.id.listView);
        loadList();
    }

    /**
     * Simple method to set up the list
     */
    private void loadList () {

        // Create a list based on String Array
        List<String> layoutList = new ArrayList<String>(Arrays.asList(layoutItems));

        // Create the Array Adapter
        layoutListAdapter =
                new ArrayAdapter<String>(
                        this, // The current context (this activity)
                        R.layout.list_item_layout, // The name of the layout ID.
                        R.id.list_item_layout_text, // The ID of the textview to populate.
                        layoutList);

        // Link the adapter with the view
        layoutListView.setAdapter(layoutListAdapter);

        // Add the handler for click event
        layoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String layoutName = layoutListAdapter.getItem(position);

                Log.d("PELLODEBUG", "Selected name: " + layoutName);
                Toast.makeText(MainActivity.this, layoutName, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this, LinearLayoutHorizontal.class);
                        break;
                    default:
                        break;
                }
            }

        });
    }

}
