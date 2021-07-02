package com.popularpenguin.nonogram.model

data class Cell(
    var isSolution: Boolean,
    var content: Content = Content.Empty
)

enum class Content { Empty, Filled, Skip, Guess }

