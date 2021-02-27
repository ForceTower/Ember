package dev.forcetower.ember.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.forcetower.ember.databinding.FragmentMainBinding
import dev.forcetower.toolkit.components.BaseFragment

@AndroidEntryPoint
class MainFragment : BaseFragment() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }
}