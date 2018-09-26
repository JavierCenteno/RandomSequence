# RandomGenerator

## About

This project offers an API for random number generation and some implementations that use it.

## License

[This API is licensed under a GNU general public license.](./LICENSE "LICENSE")

## Usage

The `api` package contains the `RandomGenerator` interface. In order to use it, you just need to implement the non-default methods. The `api` package also contains partial implementations for generators with states of different sizes: `Abstract8RandomGenerator` for generators with 8 bit states, `Abstract16RandomGenerator` for generators with 16 bit states, `Abstract32RandomGenerator` for generators with 32 bit states and `Abstract64RandomGenerator` for generators with 64 bit states.

## Methods

This API includes methods to get and set the state of a generator, generate each type of value with different distributions and parameters, pick elements from collections and shuffle them.

Distributions include:
* Uniform distribution
* Bates distribution
* Normal distribution
* Lognormal distribution
* Triangular distribution
* Pareto distribution
* Weibull distribution
* Exponential distribution
* Gamma distribution
* Beta distribution
* Poisson distribution

## Generators

The `generators` package contains a few implementations of the API with some well known random number generators.
