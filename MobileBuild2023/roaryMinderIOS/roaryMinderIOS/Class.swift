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
    var test = getClassesFromDB()
    let chatRepo = shared.ChatRepo(messages: NSMutableArray(array: []))
    
    func createTestAssignments() -> [shared.Assignment] {
        return [
            shared.Assignment(assName: "String", assDescription: "String", assChat: chatRepo),
            shared.Assignment(assName: "String2", assDescription: "String2", assChat: chatRepo)
        ]
    }
    
    var test2: [shared.Assignment] {
        createTestAssignments()
    }

    let test3 = getClassesFromDB()
}
