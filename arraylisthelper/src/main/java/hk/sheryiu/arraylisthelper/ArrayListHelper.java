package hk.sheryiu.arraylisthelper;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by sheryiu on 9/9/2016.
 */

public class ArrayListHelper<T> {

	private RecyclerView.Adapter adapter;
	private ArrayList<T> source;

	public ArrayListHelper(RecyclerView.Adapter adapter, ArrayList<T> source) {
		setDataSource(adapter, source);
	}

	public ArrayListHelper() {
		this(null, null);
	}

	protected void setDataSource(RecyclerView.Adapter adapter, ArrayList<T> source) {
		this.adapter = adapter;
		this.source = source;
	}

	protected void updateDataSource(ArrayList<T> newsource) {
		// match new list with old list
		int[] matchingPos = new int[newsource.size()];
		int totalNew = 0;
		for (int i = 0; i < newsource.size(); i++) {
			boolean matched = false;
			T newitem = newsource.get(i);
			for (int oldi = i - totalNew; oldi < source.size(); oldi++) {
				T olditem = source.get(oldi);
				if (newitem.equals(olditem)) {
					matchingPos[i] = oldi + totalNew;
					matched = true;
					break;
				}
			}
			if (!matched) {
				matchingPos[i] = -1;
				totalNew++;
			}
		}

		for (int i = 0; i < matchingPos.length; i++) {

			// items inserted
			if (matchingPos[i] == -1) {
				source.add(i, newsource.get(i));
				adapter.notifyItemInserted(i);
			} else
			// items deleted
			if ((i > 0 && matchingPos[i] != matchingPos[i - 1] + 1) || (i == 0 && matchingPos[i] != 0)) {
				for (int k = 0; k < matchingPos[i] - i; k++) {
					source.remove(i);
				}
				adapter.notifyItemRangeRemoved(i, matchingPos[i] - i);
			}
		}
		// items deleted at the end
		if (source.size() > newsource.size()) {
			int size = source.size();
			for (int k = 0; k < size - newsource.size(); k++) {
				source.remove(newsource.size());
			}
			adapter.notifyItemRangeRemoved(newsource.size(), size - newsource.size());
		}

		// finish
	}
}
