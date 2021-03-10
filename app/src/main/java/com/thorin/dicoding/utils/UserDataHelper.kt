package com.thorin.dicoding.utils

import com.thorin.dicoding.R
import com.thorin.dicoding.model.DataUsers

//cast ini sudah aman sehingga UNCHECKED_CAST
@Suppress("UNCHECKED_CAST")

class UserDataHelper {

    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            val userList = ArrayList<DataUsers>()
            userList.add(DataUsers("JakeWharton", "Jake Wharton", R.drawable.user1, "56995","12","Google, Inc.","Pittsburgh, PA, USA","102"))
            userList.add(DataUsers("amitshekhariitbhu","AMIT SHEKHAR", R.drawable.user2,"5153","2","MindOrksOpenSource","New Delhi, India","37"))
            userList.add(DataUsers("romainguy","Romain Guy", R.drawable.user3,"7972","0","Google","California","9"))
            userList.add(DataUsers("chrisbanes","Chris Banes", R.drawable.user4,"14725","1","Google Working On Android","Sydney, Australia","30"))
            userList.add(DataUsers("tipsy","David", R.drawable.user5,"788","0","Working Group Two","Trondheim, Norway","56"))
            userList.add(DataUsers("ravi8x","Ravi Tamada", R.drawable.user6,"18628","3","AndroidHive|Droid5","India","28"))
            userList.add(DataUsers("jasoet","Deny Prasetyo", R.drawable.user7,"277","39","Gojek-engineering","Kotagede, Yogyakarta, Indonesia","44"))
            userList.add(DataUsers("budioktaviyan","Budi Oktaviyan", R.drawable.user8,"178","23","KotlinID","Jakarta, Indonesia","110"))
            userList.add(DataUsers("hendisantika","Hendi Santika", R.drawable.user9,"428","61","JVMDeveloperID KotlinID IDDevOps","Bojongsoang - Bandung Jawa Barat","1064"))
            userList.add(DataUsers("sidiqpermana","Sidiq Permana", R.drawable.user10,"465","10","Nusantara Beta Studio","Jakarta Indonesia","65"))
            return userList as ArrayList
        }
    }
}