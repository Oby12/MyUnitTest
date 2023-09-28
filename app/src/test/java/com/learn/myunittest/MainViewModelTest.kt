package com.learn.myunittest

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock

import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    //pengujian volume
    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    /*private val dummyVolume = 504.0*/

    //pengujian menghitung luas dan keliling
    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before  //<-Fungsinya untuk menginisialisasi method sebelum melakukan test.
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)  //<-mock(): fungsinya untuk membuat objek mock yang akan menggantikan objek yang asli.
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
        //note
        //Angka 0.0001 pada parameter ketiga dalam assertEquals() adalah angka delta
        //yang merupakan selisih range di belakang koma bilangan double.
    }

    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val circumference = mainViewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        mainViewModel = MainViewModel(cuboidModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }
    //Pengujian Menggunakan MOCK
    @Test
    fun testMockVolume() {
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume) //<-thenReturn(): digunakan untuk memanipulasi output dari mock object.
        val volume = mainViewModel.getVolume()
        verify(cuboidModel).getVolume() //<-verify(): digunakan untuk memeriksa metode dipanggil dengan argumen yang diberikan
        assertEquals(dummyVolume, volume, 0.0001)  //<-assertEquals(): fungsi ini merupakan fungsi dari JUnit yang digunakan untuk memvalidasi output yang diharapkan dan output yang sebenarnya.
    }
    @Test
    fun testMockCircumference() {
        `when`(mainViewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCircumference()
        verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }
    @Test
    fun testMockSurfaceArea() {
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

}