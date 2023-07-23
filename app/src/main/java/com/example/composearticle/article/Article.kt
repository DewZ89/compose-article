package com.example.composearticle.article

import androidx.compose.ui.graphics.painter.Painter

data class Article(val image: Painter, val title: String, val summary: String, val content: String)
