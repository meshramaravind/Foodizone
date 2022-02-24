package com.arvind.foodizone.component

import android.content.res.Configuration
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.foodizone.R
import com.arvind.foodizone.data.CategoriesRepository
import com.arvind.foodizone.model.Categories
import com.arvind.foodizone.ui.theme.FoodizoneTheme
import com.arvind.foodizone.view.LoginScreen

@Composable
fun CategoryTabs(
    categories: List<Categories>,
    selectedCategory: Categories,
    onCategorySelected: (Categories) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = categories.indexOf(selectedCategory),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        edgePadding = 8.dp,
        indicator = {},
        divider = {}
    ) {
        categories.forEach { category ->
            CategoryTab(
                category = category,
                selected = category == selectedCategory,
                onClick = { onCategorySelected(category) },
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
            )
        }
    }
}

private enum class CategoryTabState { Selected, NotSelected }

@Composable
private fun CategoryTab(
    category: Categories,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val transition = updateTransition(
        if (selected) CategoryTabState.Selected else CategoryTabState.NotSelected,
        label = ""
    )

    val backgroundColor by transition.animateColor(label = "") { state ->
        when (state) {
            CategoryTabState.Selected -> MaterialTheme.colors.primary
            CategoryTabState.NotSelected -> MaterialTheme.colors.background
        }
    }
    val contentColor by transition.animateColor(label = "") { state ->
        when (state) {
            CategoryTabState.Selected -> LocalContentColor.current
            CategoryTabState.NotSelected -> MaterialTheme.colors.primary
        }
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = backgroundColor,
        contentColor = contentColor,
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NetworkImage(
                imageUrl = category.image,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentWidth()
                    .height(32.dp),
                previewPlaceholder = R.drawable.burger
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.name,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Composable
@Preview
fun CategoryTabsPreviewPreview() {
    CategoryTabs(
        categories = CategoriesRepository.getCategoriesData(),
        selectedCategory = CategoriesRepository.getCategoriesData().first(),
        onCategorySelected = {}
    )
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CategoryTabsPreviewDarkPreview() {
    CategoryTabs(
        categories = CategoriesRepository.getCategoriesData(),
        selectedCategory = CategoriesRepository.getCategoriesData().first(),
        onCategorySelected = {}
    )
}

@Preview("CategoryTab • Selected")
@Composable
private fun CategoryTabSelectedPreview() {
    FoodizoneTheme {
        CategoryTab(
            category = Categories(
                id = 0,
                name = "Burgers",
                image = ""
            ),
            selected = true,
            onClick = {}
        )
    }
}

@Preview("CategoryTab • NotSelected")
@Composable
private fun CategoryTabNotSelectedPreview() {
    FoodizoneTheme {
        CategoryTab(
            category = Categories(
                id = 0,
                name = "Burgers",
                image = ""
            ),
            selected = false,
            onClick = {}
        )
    }
}

@Preview("CategoryTab • Selected • Dark")
@Composable
private fun CategoryTabSelectedDarkPreview() {
    FoodizoneTheme(darkTheme = false) {
        CategoryTab(
            category = Categories(
                id = 0,
                name = "Burgers",
                image = ""
            ),
            selected = true,
            onClick = {}
        )
    }
}

@Preview("CategoryTab • NotSelected • Dark")
@Composable
private fun CategoryTabNotSelectedDarkPreview() {
    FoodizoneTheme(darkTheme = false) {
        CategoryTab(
            category = Categories(
                id = 0,
                name = "Burgers",
                image = ""
            ),
            selected = false,
            onClick = {}
        )
    }
}
