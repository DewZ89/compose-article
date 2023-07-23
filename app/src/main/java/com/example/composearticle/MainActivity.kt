package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

import com.example.composearticle.article.Article

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val article = Article(
                        image = painterResource(id = R.drawable.bg_compose_background),
                        title = stringResource(id = R.string.title),
                        summary = stringResource(id = R.string.summary),
                        content = stringResource(id = R.string.content)
                    )
                    Article(article)
                }
            }
        }
    }
}

@Composable
fun Article(article: Article, modifier: Modifier = Modifier) {
    Column {
        ArticleImage(image = article.image)
        ArticleTitle(text = article.title)
        ArticleSummary(text = article.summary)
        ArticleContent(text = article.content)
    }
}

@Composable
fun ArticleImage(image: Painter, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = "Article illustration",
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArticleTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun ArticleSummary(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier = modifier.padding(horizontal = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun ArticleContent(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ArticleImagePreview() {
    ComposeArticleTheme {
        ArticleImage(image = painterResource(id = R.drawable.bg_compose_background))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleTitle() {
    ComposeArticleTheme {
        ArticleTitle(text = stringResource(id = R.string.title))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleSummary() {
    ComposeArticleTheme {
        ArticleSummary(text = stringResource(id = R.string.summary))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleContent() {
    ComposeArticleTheme {
        ArticleContent(text = stringResource(id = R.string.content))
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme() {
        val article = Article(
            image = painterResource(id = R.drawable.bg_compose_background),
            title = stringResource(id = R.string.title),
            summary = stringResource(id = R.string.summary),
            content = stringResource(id = R.string.content)
        )
        Article(article)
    }
}