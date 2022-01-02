package com.ram.kotlincoroutinerefresh

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.ram.kotlincoroutinerefresh.model.OrgModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    public val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)
    var adapter: OrgAdapter? = null;
    var recylerView: RecyclerView? = null
    var layoutManager: LinearLayoutManager? = null
    var activity: Activity? = null;

    @Before
    fun setUpTest() {
        activity = activityRule.activity
        val context = activity as Context
        recylerView = activity!!.findViewById(R.id.recycle)
        val org1 = OrgModel(
            "hello", "ram", "gounder", "gentle", "success", "victory",
            "AllisWell", "Good"
        )
        val org2 = OrgModel(
            "hello1", "ram1", "gounder1", "gentle1", "success1", "victory1",
            "AllisWell1", "Good1"
        )
        val mitableList = mutableListOf<OrgModel>()
        mitableList.add(org1)
        mitableList.add(org2)
        layoutManager = LinearLayoutManager(context)
        adapter = OrgAdapter(context)
        adapter?.setOrgsData(mitableList)
    }

    @Test
    fun testViews() {
        activity?.runOnUiThread {
            recylerView!!.layoutManager = layoutManager
            recylerView!!.adapter = adapter
        }
    }
}