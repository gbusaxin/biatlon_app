package com.example.trainingsystem.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trainingsystem.databinding.ActivityMainBinding
import com.example.trainingsystem.presentation.adapters.ViewPagerAdapter
import com.example.trainingsystem.presentation.fragments.CandidatesFragment
import com.example.trainingsystem.presentation.fragments.NewsFragment
import com.example.trainingsystem.presentation.fragments.WorldCupFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var adapter: ViewPagerAdapter

    lateinit var newsFragment : NewsFragment
    lateinit var worldCupFragment: WorldCupFragment
    lateinit var candidatesFragment: CandidatesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabs = binding.tabLayout

        newsFragment = NewsFragment()
        worldCupFragment = WorldCupFragment()
        candidatesFragment = CandidatesFragment()

        val support = supportFragmentManager
        adapter = ViewPagerAdapter(support)

        adapter.addFragment(newsFragment,"НОВОСТИ")
        adapter.addFragment(worldCupFragment,"World Cup")
        adapter.addFragment(candidatesFragment,"Кандидаты")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }
}