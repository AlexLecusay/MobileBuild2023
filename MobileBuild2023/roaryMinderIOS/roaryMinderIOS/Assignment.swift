//
//  Assignment.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 4/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import SwiftUI

extension Assignments: Identifiable {
    public var id: UUID {
        return UUID()
    }
    
}

func addAssignment(assignmentName: String, assignmentDescription: String,course: RoaryRepoInfo,viewModel:RoaryViewModel) {
        var newAssignment = Assignments()
        var chatRepo = ChatRepos()
    newAssignment.chatRepo = chatRepo
    newAssignment.assignmentName = assignmentName
    newAssignment.assignmentDescription = assignmentDescription
//    course.classAssignments.add(newAssignment)
    viewModel.saveAssignment(assignment: newAssignment, classForRepo: course)
    print("test")
    
//        let newAssignment = assignments(assName: assignmentName, assDescription: assignmentDescription, assChat: chatRepo)
//        assignments.wrappedValue.append(newAssignment)
    }

//func addAssignment(message: String) -> String{
//    if assignmentName.isEmpty || assignmentDescription.isEmpty {
//        return
//    }
//    let newAssignment = Assignment(name: assignmentName, description: assignmentDescription)
//    assignments.append(newAssignment)
//    assignmentName = ""
//    assignmentDescription = ""
//    self.presentationMode.wrappedValue.dismiss()
//}
//
//struct Assignment: Identifiable {
//    var id = UUID()
//    var title: String
//    var description: String
//    var date: Date
//    var course: String
//    var chats: ChatRepo
//}
