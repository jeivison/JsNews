package com.example.jsnews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jsnews.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updset(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllarticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}