package com.example.common.mapper

import io.reactivex.rxjava3.core.Single

/**
 *  mapper
 */

interface Mapper<I, O> {

    fun from(i:I): O

    fun to(o: O): I

    fun fromList(list: List<I>): List<O> =
        list?.mapNotNull { from(it) } ?: listOf()

    fun toList(list: List<O>): List<I> =
        list?.mapNotNull { to(it) } ?: listOf()
}

