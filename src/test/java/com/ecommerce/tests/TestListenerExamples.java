package com.ecommerce.tests;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListenerExamples implements ITestListener, ISuiteListener ,IInvokedMethodListener,IAnnotationTransformer{

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("THIS IS BEFORE INVOCATION METHOD");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("THIS IS AFTER INVOCATION METHOD");
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("SETTING UP QA ENV");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("TEAR DOWN THE QA ENV");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("This is ON TEST START");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test "+result.getName()+" passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test "+result.getName()+" failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test "+result.getName()+" SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("---------TEST STARTED----------");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------TEST FINISHED----------");
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
        if(testMethod.getName().equals("pageDetailsVerif")){
            System.out.println("ON PURPOSE THIS METHOD SKIPPED IN IANNOTIONLISTERNER");
        }
    }
}
