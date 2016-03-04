package fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.karen.navdrawer.R;
import com.example.karen.navdrawer.ViewRenderedImage;

public class SavedHousesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_savedhouses, container, false);
        String a[] = {"hi", "hello", "hi there"};
        ArrayAdapter adapter = new ArrayAdapter<String>(container.getContext(), R.layout.fragment_savedhouses, a);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
//        int items = 1;
//        String a[] = new String[1];
//        a[0] = "1";
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(rootView.getContext(), R.layout.fragment_savedhouses, a);
//        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
//        listView.setAdapter(itemsAdapter);

        return rootView;

    }
}
