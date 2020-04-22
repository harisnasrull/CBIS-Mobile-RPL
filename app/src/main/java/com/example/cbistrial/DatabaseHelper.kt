package com.example.cbistrial

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cbistrial.table.*

class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "cbis.db"
        const val COLUMN_ID = "_id"
        const val COLUMN_NIM = "nim"
        const val COLUMN_CODE = "kode"
        const val COLUMN_NAMA = "nama"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_STATUS = "status"
        const val COLUMN_TITLE = "judul"
        const val COLUMN_ISI = "isi"
        const val COLUMN_DATE = "tanggal"
        const val COLUMN_DAY = "hari"
        const val COLUMN_SESSION = "sesi"
        const val COLUMN_NILAI = "nilai"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_MAHASISWA_TABLE = ("CREATE TABLE mahasiswa("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_NIM TEXT NOT NULL,"
                +"$COLUMN_NAMA TEXT NOT NULL,"
                +"$COLUMN_PASSWORD TEXT NOT NULL,"
                +"$COLUMN_STATUS TEXT NOT NULL)")
        val CREATE_DOSEN_TABLE = ("CREATE TABLE dosen("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_CODE TEXT NOT NULL,"
                +"$COLUMN_NAMA TEXT NOT NULL,"
                +"$COLUMN_PASSWORD TEXT NOT NULL,"
                +"$COLUMN_STATUS TEXT NOT NULL)")
        val CREATE_ADMIN_TABLE = ("CREATE TABLE admin("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_CODE TEXT NOT NULL,"
                +"$COLUMN_PASSWORD TEXT NOT NULL,"
                +"$COLUMN_STATUS TEXT NOT NULL)")
        val CREATE_NEWS_TABLE = ("CREATE TABLE berita("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_TITLE TEXT NOT NULL,"
                +"$COLUMN_ISI TEXT NOT NULL,"
                +"$COLUMN_DATE TEXT NOT NULL)")
        val CREATE_MATA_KULIAH_TABLE = ("CREATE TABLE matkul("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_CODE TEXT NOT NULL,"
                +"$COLUMN_NAMA TEXT NOT NULL)")
        val CREATE_JADWAL_TABLE = ("CREATE TABLE jadwal("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_CODE TEXT NOT NULL,"
                +"kode_matkul TEXT NOT NULL,"
                +"kode_dosen TEXT NOT NULL,"
                +"$COLUMN_DAY TEXT NOT NULL,"
                +"$COLUMN_SESSION TEXT NOT NULL)")
        val CREATE_JADWAL_KULIAH_TABLE = ("CREATE TABLE jadwalkuliah("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"$COLUMN_CODE TEXT NOT NULL,"
                +"kode_jadwal TEXT NOT NULL,"
                +"$COLUMN_NIM TEXT NOT NULL,"
                )
        val CREATE_JADWAL_UJIAN_TABLE = ("CREATE TABLE jadwalujian("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"kode_jadwal TEXT NOT NULL,"
                +"$COLUMN_DATE TEXT NOT NULL)")
        val CREATE_NILAI_TABLE = ("CREATE TABLE nilai("
                +"$COLUMN_ID INTEGER PRIMARY KEY,"
                +"nim_mahasiswa INTEGER NOT NULL,"
                +"kode_jadwal TEXT NOT NULL,"
                +"$COLUMN_NILAI TEXT NOT NULL)")
        db?.execSQL(CREATE_MAHASISWA_TABLE)
        db?.execSQL(CREATE_DOSEN_TABLE)
        db?.execSQL(CREATE_ADMIN_TABLE)
        db?.execSQL(CREATE_NEWS_TABLE)
        db?.execSQL(CREATE_MATA_KULIAH_TABLE)
        db?.execSQL(CREATE_JADWAL_TABLE)
        db?.execSQL(CREATE_JADWAL_KULIAH_TABLE)
        db?.execSQL(CREATE_JADWAL_UJIAN_TABLE)
        db?.execSQL(CREATE_NILAI_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS mahasiswa")
        db?.execSQL("DROP TABLE IF EXISTS dosen")
        db?.execSQL("DROP TABLE IF EXISTS admin")
        db?.execSQL("DROP TABLE IF EXISTS berita")
        db?.execSQL("DROP TABLE IF EXISTS matkul")
        db?.execSQL("DROP TABLE IF EXISTS jadwal")
        db?.execSQL("DROP TABLE IF EXISTS jadwalkuliah")
        db?.execSQL("DROP TABLE IF EXISTS jadwalujian")
        db?.execSQL("DROP TABLE IF EXISTS nilai")
        onCreate(db)
    }
    fun insertMahasiswa(mahasiswa: Mahasiswa) {
        val values = ContentValues()
        values.put(COLUMN_NIM,mahasiswa.nim)
        values.put(COLUMN_NAMA,mahasiswa.nama)
        values.put(COLUMN_PASSWORD,mahasiswa.password)
        values.put(COLUMN_STATUS,mahasiswa.status)
        val db = this.writableDatabase
        db.insert("mahasiswa",null,values)
        db.close()
    }
    fun insertDosen(dosen: Dosen) {
        val values = ContentValues()
        values.put(COLUMN_CODE,dosen.nim)
        values.put(COLUMN_NAMA,dosen.nama)
        values.put(COLUMN_PASSWORD,dosen.password)
        values.put(COLUMN_STATUS,dosen.status)
        val db = this.writableDatabase
        db.insert("dosen",null,values)
        db.close()
    }
    fun insertAdmin(admin: Admin) {
        val values = ContentValues()
        values.put(COLUMN_CODE,admin.code)
        values.put(COLUMN_PASSWORD,admin.password)
        values.put(COLUMN_STATUS,admin.status)
        val db = this.writableDatabase
        db.insert("admin",null,values)
        db.close()
    }
    fun insertBerita(berita: Berita) {
        val values = ContentValues()
        values.put(COLUMN_TITLE,berita.judul)
        values.put(COLUMN_ISI,berita.isi)
        values.put(COLUMN_DATE,berita.tanggal)
        val db = this.writableDatabase
        db.insert("berita",null,values)
        db.close()
    }
    fun insertMataKuliah(matkul: Matkul) {
        val values = ContentValues()
        values.put(COLUMN_CODE,matkul.code)
        values.put(COLUMN_NAMA,matkul.nama)
        val db = this.writableDatabase
        db.insert("matkul",null,values)
        db.close()
    }
    fun insertJadwal(jadwal: Jadwal) {
        val values = ContentValues()
        values.put(COLUMN_CODE,jadwal.code)
        values.put("kode_matkul",jadwal.kode_matkul)
        values.put("kode_dosen",jadwal.kode_dosen)
        values.put(COLUMN_DAY,jadwal.hari)
        values.put(COLUMN_SESSION,jadwal.sesi)
        val db = this.writableDatabase
        db.insert("jadwal",null,values)
        db.close()
    }
    fun insertJadwalKuliah(jadwalKuliah: JadwalKuliah) {
        val values = ContentValues()
        values.put("kode_matkul",jadwalKuliah.kode_jadwal_kuliah)
        values.put("nim_mahasiswa",jadwalKuliah.nim_mahasiswa)
        val db = this.writableDatabase
        db.insert("jadwalkuliah",null,values)
        db.close()
    }
    fun insertUjian(jadwalUjian: JadwalUjian) {
        val values = ContentValues()
        values.put("kode_jadwal",jadwalUjian.kode_jadwal)
        values.put(COLUMN_DATE,jadwalUjian.tanggal)
        val db = this.writableDatabase
        db.insert("jadwalujian",null,values)
        db.close()
    }
    fun insertNilai(nilai: Nilai) {
        val values = ContentValues()
        values.put("nim_mahasiswa",nilai.nim_mahasiswa)
        values.put("kode_jadwal",nilai.kode_jadwal)
        values.put(COLUMN_NILAI,nilai.nilai)
        val db = this.writableDatabase
        db.insert("nilai",null,values)
        db.close()
    }

    fun getMahasiswa(): ArrayList<Mahasiswa> {
        val listMhs = ArrayList<Mahasiswa>()
        val query = "SELECT * FROM mahasiswa"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val mhs = Mahasiswa(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4))
                listMhs.add(mhs)
            } while (cursor.moveToNext())
        }
        db.close()
        return listMhs
    }
    fun cekMahasiswa(code: String,password:String): Boolean{
        val listMhs = ArrayList<Mahasiswa>()
        val query = "SELECT * FROM mahasiswa"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        var cek: Boolean = false
        if (cursor.moveToFirst()){
            do {
                val mhs = Mahasiswa(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4))
                if (cursor.getString(1) == code && cursor.getString(3) == password){
                    cek = true
                }
                listMhs.add(mhs)
            } while (cursor.moveToNext())
        }
        return cek
    }
    fun getDosen(): ArrayList<Dosen> {
        val listDosen = ArrayList<Dosen>()
        val query = "SELECT * FROM dosen"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val dosen = Dosen(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4))
                listDosen.add(dosen)
            } while (cursor.moveToNext())
        }
        db.close()
        return listDosen
    }
    fun cekDosen(code: String,password:String): Boolean{
        val listDosen = ArrayList<Dosen>()
        val query = "SELECT * FROM dosen"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        var cek: Boolean = false
        if (cursor.moveToFirst()){
            do {
                val dosen = Dosen(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4))
                if (cursor.getString(1) == code && cursor.getString(3) == password){
                    cek = true
                }
                listDosen.add(dosen)
            } while (cursor.moveToNext())
        }
        return cek
    }
    fun cekAdmin(code: String,password:String): Boolean{
        val listAdmin = ArrayList<Admin>()
        val query = "SELECT * FROM admin"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        var cek: Boolean = false
        if (cursor.moveToFirst()){
            do {
                val admin = Admin(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3))
                if (cursor.getString(1) == code && cursor.getString(2) == password){
                    cek = true
                }
                listAdmin.add(admin)
            } while (cursor.moveToNext())
        }
        return cek
    }
    fun getAdmin(): ArrayList<Admin> {
        val listAdmin = ArrayList<Admin>()
        val query = "SELECT * FROM admin"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val admin = Admin(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3))
                admin.id = cursor.getInt(0)
                listAdmin.add(admin)
            } while (cursor.moveToNext())
        }
        db.close()
        return listAdmin
    }
    fun getBerita(): ArrayList<Berita> {
        val listBerita = ArrayList<Berita>()
        val query = "SELECT * FROM berita"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val berita = Berita(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3))
                listBerita.add(berita)
            } while (cursor.moveToNext())
        }
        db.close()
        return listBerita
    }
    fun getMatkul(): ArrayList<Matkul> {
        val listMatkul = ArrayList<Matkul>()
        val query = "SELECT * FROM matkul"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val matkul = Matkul(
                    cursor.getString(1),
                    cursor.getString(2)
                )
                listMatkul.add(matkul)
            } while (cursor.moveToNext())
        }
        db.close()
        return listMatkul
    }
    fun getJadwal(): ArrayList<Jadwal> {
        val listJadwalKuliah = ArrayList<Jadwal>()
        val query = "SELECT * FROM jadwal"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val jadwalKuliah = Jadwal(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                )
                listJadwalKuliah.add(jadwalKuliah)
            } while (cursor.moveToNext())
        }
        db.close()
        return listJadwalKuliah
    }
    fun getJadwalKuliah(): ArrayList<JadwalKuliah> {
        val listJadwalKuliah = ArrayList<JadwalKuliah>()
        val query = "SELECT * FROM jadwalkuliah"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val jadwalKuliah = JadwalKuliah(
                    cursor.getString(1),
                    cursor.getString(2)
                )
                listJadwalKuliah.add(jadwalKuliah)
            } while (cursor.moveToNext())
        }
        db.close()
        return listJadwalKuliah
    }
    fun getJadwalUjian(): ArrayList<JadwalUjian> {
        val listJadwalUjian = ArrayList<JadwalUjian>()
        val query = "SELECT * FROM jadwalujian"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val jadwalUjian = JadwalUjian(
                    cursor.getString(1),
                    cursor.getString(2)
                )
                listJadwalUjian.add(jadwalUjian)
            } while (cursor.moveToNext())
        }
        db.close()
        return listJadwalUjian
    }
    fun getNilai(): ArrayList<Nilai> {
        val listNilai = ArrayList<Nilai>()
        val query = "SELECT * FROM nilai"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                val nilai = Nilai(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )
                listNilai.add(nilai)
            } while (cursor.moveToNext())
        }
        db.close()
        return listNilai
    }

    fun deleteMahasiswa(id: Int){
        val db = this.writableDatabase
        db.delete("mahasiswa","nim = $id",null)
    }
    fun deleteAdmin(id: Int){
        val db = this.writableDatabase
        db.delete("admin","_id = $id",null)
    }
    fun deleteDosen(id: Int){
        val db = this.writableDatabase
        db.delete("dosen","_id = $id",null)
    }
    fun deleteBerita(id: Int){
        val db = this.writableDatabase
        db.delete("berita","_id = $id",null)
    }
    fun deleteMatkul(id: Int){
        val db = this.writableDatabase
        db.delete("matkul","_id = $id",null)
    }
    fun deleteJadwal(id: Int){
        val db = this.writableDatabase
        db.delete("jadwal","_id = $id",null)
    }
    fun deleteJadwalKuliah(id: Int){
        val db = this.writableDatabase
        db.delete("jadwalkuliah","_id = $id",null)
    }
    fun deleteJadwalUjian(id: Int){
        val db = this.writableDatabase
        db.delete("jadwalujian","_id = $id",null)
    }
    fun deleteNilai(id: Int){
        val db = this.writableDatabase
        db.delete("nilai","_id = $id",null)
    }
}