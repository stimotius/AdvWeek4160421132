package com.ubaya.advweek4160421132.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.advweek4160421132.R
import com.ubaya.advweek4160421132.databinding.FragmentStudentListBinding
import com.ubaya.advweek4160421132.viewmodel.ListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StudentListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter  = StudentListAdapter(arrayListOf())
    private lateinit var binding:FragmentStudentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = studentListAdapter

        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
        studentListAdapter.updateStudentList(it)
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {if(it == true) {
            binding.txtError?.visibility = View.VISIBLE
        } else {
            binding.txtError?.visibility = View.GONE
        }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {if(it == true) {
            binding.recView.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
        } else {
            binding.recView.visibility = View.VISIBLE
            binding.progressLoad.visibility = View.GONE
        }
        })

    }


}