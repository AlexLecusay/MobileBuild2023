//
//  Class.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/24/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
//struct Class {
//    let title: String
//    let description: String
//    let assignments: [Assignment]
//    let isHomePage: Bool
//
//    init(title: String, description: String, isHomePage: Bool, assignments: [Assignment] = []) {
//        self.title = title
//        self.description = description
//        self.isHomePage = isHomePage
//        self.assignments = assignments
//    }
//}

func getClassesFromDB() -> [shared.Class] {
    let response = RoaryViewModel().loadClasses()
    return response
}







struct Test {
    static let psychologyAssignments = [
        Assignment(title: "Research Paper", description: "Write a 10-page research paper on a topic of your choice in psychology.", date: Date().addingTimeInterval(86400), course: "Introduction to Psychology", chats: ChatRepo(messages: ["Hi, can you help me with my paper?"])),
        Assignment(title: "Exam 1", description: "Take the first exam covering chapters 1-3 of the textbook.", date: Date().addingTimeInterval(172800), course: "Introduction to Psychology", chats: ChatRepo(messages: ["Do you know if the exam is multiple choice or essay?"]))
    ]

    var test = getClassesFromDB()

    let test2 = [
        Assignment(title: "New Notification", description: "test", date: Date(), course: "Introduction to Psychology", chats: ChatRepo(messages: ["message1","message2"]))
    ]
    let test3 = getClassesFromDB()
}


