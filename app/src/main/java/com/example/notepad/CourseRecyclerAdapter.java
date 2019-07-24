package com.example.notepad;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/*NoteRecyclerAdapter used to hold the information for individual views
Adapter is the workhorse for RecyclerView
 */
public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<CourseInfo> mCourses;
    private final LayoutInflater layoutInflater;

    public CourseRecyclerAdapter(Context mContext, List<CourseInfo> mCourses) {
        this.mContext = mContext;

        layoutInflater = LayoutInflater.from(mContext);
        this.mCourses = mCourses;
    }

    //Creates our view holder instances and create the views themselves
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*itemView points to the root of the view that is created when the layout resource is inflated
        It would be our top level view
       This will be used by the RecyclerView to create the pool of views
         */
        View itemView = layoutInflater.inflate(R.layout.item_course_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    /*Associates data with our view on the desired position
    Set the position each time our holder is associated with different data
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CourseInfo course = mCourses.get(position);
        viewHolder.textCourse.setText(course.getTitle());
        viewHolder.mCurrentPosition = position;
    }

    //Indicates the number of  data items we have
    @Override
    public int getItemCount() {
        return mCourses.size();
    }
/*
This view holder is supposed to keep references of the views we have to set at runtime
We need to know what position the view holder is currently associated with
currentPosition needs to be set every time the viewHolder is associated with a different note
RecyclerView selection
    No explicit item selection support
    Contained views handle click event
    Supports SingleItemSelection-Click handler added to top-level view
    MultipleSelectionWithinItems-Contained views provide click handler
Associate a click event handler with an item view
This will show the note regardless of where was clicked
 */
    public class ViewHolder extends RecyclerView.ViewHolder{

    //Made public so that our outer class the NoteRecyclerAdapter to reference these fields directly
    public final TextView textCourse;
    public int mCurrentPosition;

    public ViewHolder(@NonNull View itemView) {
            super(itemView);
        textCourse = itemView.findViewById(R.id.text_course);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NoteActivity.class);
                intent.putExtra(NoteActivity.NOTE_POSITION, mCurrentPosition);
                mContext.startActivity(intent);
            }
        });
        }
    }
}
