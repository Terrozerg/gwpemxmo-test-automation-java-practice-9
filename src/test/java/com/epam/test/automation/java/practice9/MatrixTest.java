package com.epam.test.automation.java.practice9;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixTest{

    Matrix matrix;

    @Test
    public void testConstructorBySize(){
        matrix = new Matrix(1,2);
        double[][] expected = new double[1][2];

        Assert.assertEquals(matrix.twoDimensionalArrayOutOfMatrix(), expected);
    }

    @Test
    public void testConstructorByValue() throws MatrixException {
        double[][] source = new double[][]{{1,2,3},{2,4,9},{4,7,2}};
        matrix = new Matrix(source);

        Assert.assertEquals(matrix.twoDimensionalArrayOutOfMatrix(), source);
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Array passed with zero number of rows")
    public void testConstructorByValueIncompatibleByRow() throws MatrixException {
        double[][] source = new double[0][4];
        matrix = new Matrix(source);

        Assert.assertEquals(matrix.twoDimensionalArrayOutOfMatrix(), source);
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Array passed with zero number of columns")
    public void testConstructorByValueIncompatibleByColumn() throws MatrixException {
        double[][] source = new double[3][0];
        matrix = new Matrix(source);

        Assert.assertEquals(matrix.twoDimensionalArrayOutOfMatrix(), source);
    }

    @Test
    public void testGetRows(){
        matrix = new Matrix(2,6);

        int expected = 2;

        Assert.assertEquals(matrix.rows(), expected);
    }

    @Test
    public void testGetColumns(){
        matrix = new Matrix(2,6);

        int expected = 6;

        Assert.assertEquals(matrix.columns(), expected);
    }

    @Test
    public void testGetArrayOutOfMatrix() throws MatrixException {
        double[][] source = new double[][]{{1,2},{2,4}};
        matrix = new Matrix(source);

        Assert.assertEquals(matrix.twoDimensionalArrayOutOfMatrix(), source);
    }

    @Test
    public void testGetValue() throws MatrixException {
        double[][] source = new double[][]{{1,2},{2,4}};
        matrix = new Matrix(source);

        int expected = 4;

        Assert.assertEquals(matrix.getValue(1,1), expected);
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Incompatible matrix sizes")
    public void testGetValueByIncorrectIndex() throws MatrixException {
        double[][] source = new double[][]{{1,2},{2,4}};
        matrix = new Matrix(source);

        matrix.getValue(10,-5);
    }

    @Test
    public void testSetValue() throws MatrixException {
        double[][] source = new double[][]{{1,2},{2,4}};
        matrix = new Matrix(source);

        matrix.setValue(1,0, 4);

        int expected = 4;

        Assert.assertEquals(matrix.getValue(1,0), expected);
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Incompatible matrix sizes")
    public void testSetValueByIncorrectIndex() throws MatrixException {
        double[][] source = new double[][]{{1,2},{2,4}};
        matrix = new Matrix(source);

        matrix.setValue(1,2, 4);
    }

    @Test
    public void testAddition() throws MatrixException {
        matrix = new Matrix(new double[][]{{2,6,4,8},{6,6,-9,-4}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{2,4,2,5}});

        Matrix expected = new Matrix(new double[][]{{3,8,12,12},{8,10,-7,1}});
        Matrix result = matrix.addition(factor);

        Assert.assertEquals(result.toString(), expected.toString());
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Incompatible matrix sizes")
    public void testAdditionWithIncompatibleSize() throws MatrixException {
        matrix = new Matrix(new double[][]{{2,6,4},{6,6,-4}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{2,4,2,5}});

        matrix.addition(factor);
    }

    @Test
    public void testSubtraction() throws MatrixException {
        matrix = new Matrix(new double[][]{{2,6,4,8},{6,6,-9,-4}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{2,4,2,5}});

        Matrix expected = new Matrix(new double[][]{{1,4,-4,4},{4,2,-11,-9}});
        Matrix result = matrix.subtraction(factor);

        Assert.assertEquals(result.toString(), expected.toString());
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Incompatible matrix sizes")
    public void testSubtractionWithIncompatibleSize() throws MatrixException {
        matrix = new Matrix(new double[][]{{2,6,4},{6,6,-4}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{2,4,2,5}});

        matrix.subtraction(factor);
    }

    @Test
    public void testMultiplication() throws MatrixException {
        matrix = new Matrix(new double[][]{{1,2},{2,4},{6,6}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{2,4,2,5}});

        Matrix expected = new Matrix(new double[][]{{5,10,12,14},{10,20,24,28},{18,36,60,54}});
        Matrix result = matrix.multiplication(factor);

        Assert.assertEquals(result.toString(), expected.toString());
    }

    @Test(expectedExceptions = MatrixException.class,
            expectedExceptionsMessageRegExp = "Incompatible matrix sizes")
    public void testMultiplicationWithIncompatibleSize() throws MatrixException {
        matrix = new Matrix(new double[][]{{1,2},{2,4},{6,6}});
        Matrix factor = new Matrix(new double[][]{{1,2,8,4},{5,7,8,1},{1,1,1,1}});

        matrix.multiplication(factor);
    }
}