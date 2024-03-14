package com.ubaya.advweek4160421132.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.advweek4160421132.databinding.StudentListItemBinding
import com.ubaya.advweek4160421132.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var binding: StudentListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.txtID.text = studentList[position].id
        holder.binding.txtName.text = studentList[position].name

        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }


}
