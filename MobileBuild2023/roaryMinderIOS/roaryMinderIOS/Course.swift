//
//  Course.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/24/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

struct Course: Identifiable {
    let id = UUID()
    let title: String
    let description: String
    let isHomePage: Bool
}

struct Test {
    let test = [
        Course(title: "Introduction to Psychology", description: "Learn about the scientific study of behavior and mental processes in this introductory psychology course.", isHomePage: true),
        Course(title: "Calculus I", description: "Explore limits, derivatives, integrals, and their applications in this calculus course.", isHomePage: false),
        Course(title: "Organic Chemistry", description: "Study the structure, properties, and reactions of organic compounds in this advanced chemistry course.", isHomePage: false),
        Course(title: "Art History", description: "Discover the history of art from ancient times to the present day in this comprehensive art history course.", isHomePage: true),
        Course(title: "Introduction to Programming", description: "Learn the fundamentals of computer programming and problem solving in this introductory programming course.", isHomePage: true),
        Course(title: "Statistics", description: "Study statistical methods and data analysis in this course on probability and statistics.", isHomePage: false),
        Course(title: "Environmental Science", description: "Explore environmental problems and solutions in this interdisciplinary course on the environment.", isHomePage: false),
        Course(title: "Introduction to Philosophy", description: "Examine fundamental philosophical questions and ideas in this introductory philosophy course.", isHomePage: false),
        Course(title: "World History", description: "Explore the history of the world from ancient times to the present day in this comprehensive history course.", isHomePage: true),
        Course(title: "Spanish I", description: "Learn the fundamentals of the Spanish language in this introductory Spanish course.", isHomePage: false),
        Course(title: "Molecular Biology", description: "Study the molecular basis of biological activity in this advanced biology course.", isHomePage: false),
        Course(title: "Literary Analysis", description: "Develop critical reading and analytical skills in this course on literary analysis and interpretation.", isHomePage: false),
        Course(title: "Digital Marketing", description: "Learn how to market products and services online in this course on digital marketing.", isHomePage: true),
        Course(title: "American Government", description: "Explore the structure and functions of the American government in this course on American government and politics.", isHomePage: false),
        Course(title: "Introduction to Astronomy", description: "Discover the wonders of the universe in this introductory astronomy course.", isHomePage: false),
        Course(title: "Introduction to Sociology", description: "Examine the social forces that shape human behavior and society in this introductory sociology course.", isHomePage: false),
        Course(title: "Creative Writing", description: "Develop your creative writing skills in this course on fiction, poetry, and creative nonfiction writing.", isHomePage: true)
    ]
}
