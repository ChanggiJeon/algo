use io::Write;
use std::{
    io::{self, stdout, Read},
    str,
};

fn main() {
    let mut input = String::new();

    io::stdin().read_line(&mut input).expect("error");

    let mut inputs = input.split_whitespace();

    let k: u32 = inputs.next().unwrap().parse().expect("error");
    let n: u32 = inputs.next().unwrap().parse().expect("error");
    let m: u32 = inputs.next().unwrap().parse().expect("error");

    if (k * n <= m) {
        println!("{}", 0);
    } else {
        println!("{}", k * n - m);
    }
}
