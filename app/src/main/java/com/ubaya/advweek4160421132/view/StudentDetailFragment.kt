package com.ubaya.advweek4160421132.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.advweek4160421132.R
import com.ubaya.advweek4160421132.databinding.FragmentStudentDetailBinding
import com.ubaya.advweek4160421132.databinding.FragmentStudentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var binding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
}