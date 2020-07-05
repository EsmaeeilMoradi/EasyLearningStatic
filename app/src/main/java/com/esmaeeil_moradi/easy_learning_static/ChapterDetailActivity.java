package com.esmaeeil_moradi.easy_learning_static;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;


public class ChapterDetailActivity extends AppCompatActivity {
    //We’ll use this constant to pass the ID of the pizza as extra information in the intent.
    public static final String EXTRA_CHAPTERS_ID = "chapterId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);

        //Set the toolbar as the activity's app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //Enable the Up button.
        actionBar.setDisplayHomeAsUpEnabled(true);

//        //Display details of the pizza
        int chapterId = (Integer) getIntent().getExtras().get(EXTRA_CHAPTERS_ID);
        String chapterName = Chapter.chapters[chapterId].getName();
        Log.e("ESSI", chapterName);


//        TextView textView = findViewById(R.id.pizza_text);
//        textView.setText(chapterName);
//        int pizzaImage = Chapter.chapters[chapterId].getImageResourceId();
//        ImageView imageView = findViewById(R.id.static_image);
//        imageView.setImageDrawable(ContextCompat.getDrawable(this,pizzaImage));
//        imageView.setContentDescription(chapterName);


        PDFView pdfView = findViewById(R.id.pdfView);

        switch (chapterName) {
            case "contents":
                PdfViewer.viewPdf("contents.pdf",
                        pdfView, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
                break;
            case "chapter1":
                PdfViewer.viewPdf("chapter1.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
                break;
            case "chapter2":
                PdfViewer.viewPdf("chapter2.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60
                        );
                break;
            case "chapter3":
                PdfViewer.viewPdf("chapter3.pdf",
                        pdfView,   0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,
                        61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80);
                break;
            case "chapter4":
                PdfViewer.viewPdf("chapter4.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60);
                break;
            case "chapter5":
                PdfViewer.viewPdf("chapter5.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64);
                break;
            case "chapter6":
                PdfViewer.viewPdf("chapter6.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,
                        61,62,63,64,65,66,67,68,69,70);
                break;
            case "chapter7":
                PdfViewer.viewPdf("chapter7.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58);
                break;
            case "chapter8":
                PdfViewer.viewPdf("chapter8.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58);
                break;
            case "chapter9":
                PdfViewer.viewPdf("chapter9.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,
                        61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88);
                break;
            case "chapter10":
                PdfViewer.viewPdf("chapter10.pdf",
                        pdfView, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44);
                break;


        }


    }

}



