package com.example.instagramclone.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.instagramclone.Models.User
import com.example.instagramclone.R
import com.example.instagramclone.SignupActivity
import com.example.instagramclone.adapters.ViewPagerAdapter
import com.example.instagramclone.databinding.ActivityLoginBinding
import com.example.instagramclone.databinding.FragmentProfileBinding
import com.example.instagramclone.utils.USER_NODE
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.squareup.picasso.Picasso
import com.google.android.material.tabs.TabLayout

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewPagerAdapter:ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentProfileBinding.inflate(inflater, container, false)

        binding.editProfile.setOnClickListener {
            val intent=Intent(activity,SignupActivity::class.java)
            intent.putExtra("MODE",1)
            activity?.startActivity(intent)
            activity?.finish()
        }

        viewPagerAdapter= ViewPagerAdapter(requireActivity().supportFragmentManager)
        viewPagerAdapter.addFragment(MyPostFragment(),"MY POST")
        viewPagerAdapter.addFragment(MyReelFragment(),"MY REEL")
        binding.viewPager.adapter=viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        
        return binding.root
    }

    companion object {

    }

    override fun onStart() {
        super.onStart()
        Firebase.firestore.collection(USER_NODE).document(Firebase.auth.currentUser!!.uid).get()
            .addOnSuccessListener {
                val user:User=it.toObject<User>()!!
                binding.name.text=user.name
                binding.bio.text=user.email
                if(user.image.isNullOrBlank()){
                    Picasso.get().load(user.image).into(binding.profileImage)
                }
            }
    }
}