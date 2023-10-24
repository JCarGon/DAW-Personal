import test from 'ava';
import { fizzbuzz } from '../src/fizzbuzz.js';

test('should be 1 for n = 1', t => {
  const result = fizzbuzz(1);
  t.is(result, 1);
});

test('should be "fizz" for n = 3', t => {
  const result = fizzbuzz(3);
  t.is(result, "fizz");
});

test('should be 4 for n = 4', t => {
  const result = fizzbuzz(4);
  t.is(result, 4);
});

test('should be "buzz" for n = 5', t => {
  const result = fizzbuzz(5);
  t.is(result, "buzz");
});

test('should be "FizzBuzz" for n = 60', t => {
  const result = fizzbuzz(60);
  t.is(result, "FizzBuzz");
});