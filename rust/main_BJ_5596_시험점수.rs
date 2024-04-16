use std::cmp;
use std::io;

fn main() {
    let mut input1 = String::new();
    let mut input2 = String::new();

    io::stdin().read_line(&mut input1).expect("msg");
    io::stdin().read_line(&mut input2).expect("msg");

    let (mut sum1, mut sum2) = (0, 0);

    let mut iter1 = input1.split_ascii_whitespace();
    let mut iter2 = input2.split_ascii_whitespace();

    for _ in 0..4 {
        sum1 += iter1.next().unwrap().parse::<i32>().expect("msg");
    }

    for _ in 0..4 {
        sum2 += iter2.next().unwrap().parse::<i32>().expect("msg");
    }

    println!("{}", cmp::max(sum1, sum2))
}
