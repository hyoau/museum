package edu.nwu.museum.common.function;

@FunctionalInterface
public interface CacheSelector<T> {

  T select() throws Exception;
}
