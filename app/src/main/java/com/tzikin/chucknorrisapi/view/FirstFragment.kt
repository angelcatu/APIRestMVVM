package com.tzikin.chucknorrisapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tzikin.chucknorrisapi.databinding.FragmentFirstBinding
import com.tzikin.chucknorrisapi.mvvm.FirstFragmentViewModel
import com.tzikin.chucknorrisapi.view.ChuckNorrisListAdapter.ChuckNorrisListAdapter
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mViewModel: FirstFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(requireActivity()).get(FirstFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fab listener
        binding.fab.setOnClickListener{
            callToChuckNorrisList()
        }

    }

    private fun callToChuckNorrisList() {

        binding.progressBar.visibility = View.VISIBLE

        GlobalScope.launch(Dispatchers.Main) {

            val iterator = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 14, 15, 16, 17 , 18, 19 , 20)

            iterator.forEach{
                val async = GlobalScope.async {
                    withContext(Dispatchers.Default){
                        var joke = mViewModel.getJoke().body()
                        joke?.let { mViewModel.jokesList.add(it) }
                    }
                }
                async.await()
            }

            binding.progressBar.visibility = View.GONE
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        binding.rvJokes.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvJokes.adapter = ChuckNorrisListAdapter(mViewModel.jokesList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}