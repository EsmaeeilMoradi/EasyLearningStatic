package com.esmaeeil_moradi.easy_learning_static;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntroChaptersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView chaptersRecycler =
                (RecyclerView) inflater.inflate(R.layout.fragment_intro_chapters, container, false);
        String[] chaptersName = new String[Chapter.chapters.length];
        for (int i = 0; i < chaptersName.length; i++) {
            chaptersName[i] = Chapter.chapters[i].getName();
        }
        int[] chapterImage = new int[Chapter.chapters.length];
        for (int i = 0; i < chapterImage.length; i++) {
            chapterImage[i] = Chapter.chapters[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(chaptersName, chapterImage);
        chaptersRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        chaptersRecycler.setLayoutManager(layoutManager);
        //This implements the Listener onClick() method.
        // It starts ChapterDetailActivity, passing it the ID of the pizza the user chose.
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ChapterDetailActivity.class);
                intent.putExtra(ChapterDetailActivity.EXTRA_CHAPTERS_ID, position);
                getActivity().startActivity(intent);

            }
        });


        return chaptersRecycler;
    }

}
