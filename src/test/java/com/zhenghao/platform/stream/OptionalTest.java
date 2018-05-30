package com.zhenghao.platform.stream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.zhenghao.platform.LearningApplicationTests;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * PROGRAM:     platform
 * Author:      Mr.jiangzhenghao
 * Date:        2018-05-26 15:18
 * Desc:        Optional 用法
 * Copyright (c) 2018, www.haiziwang.com All Rights Reserved
 */

public class OptionalTest extends LearningApplicationTests
{
  @Test
  public void test1()
  {
    Runnable runnable = () ->
        System.out.println(System.currentTimeMillis());

    new Thread(runnable).start();
  }

  @Test
  public void test2()
  {
    CompletableFuture cf = CompletableFuture.completedFuture("message");
    try {
      System.out.println(cf.get());
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    catch (ExecutionException e) {
      e.printStackTrace();
    }
    assertTrue(cf.isDone());
    assertEquals("message", cf.getNow(null));
  }


  @Test
  public void test3()
  {
    CompletableFuture cf = CompletableFuture.runAsync(()->{
      System.out.println("========>"+System.currentTimeMillis());
    });
    assertFalse(cf.isDone());
  }

  @Test
  public void test4()
  {
    CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s -> {
      assertFalse(Thread.currentThread().isDaemon());
      return s.toUpperCase();
    });
    assertEquals("MESSAGE", cf.getNow(null));
    System.out.println(cf.getNow(null));
  }

}
