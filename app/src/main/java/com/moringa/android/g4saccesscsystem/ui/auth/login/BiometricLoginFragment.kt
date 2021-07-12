package com.moringa.android.g4saccesscsystem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moringa.android.g4saccesscsystem.databinding.PhoneLayoutBinding
import com.moringa.android.g4saccesscsystem.model.Phonedetails
import java.util.*
import kotlin.jvm.internal.Intrinsics

//@Metadata(
//    mv = [1, 4, 3],
//    bv = [1, 0, 3],
//    k = 1,
//    d1 = ["\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"],
//    d2 = ["Lcom/moringa/android/g4saccesscsystem/adapter/PhonedetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView\$Adapter;", "Lcom/moringa/android/g4saccesscsystem/adapter/PhonedetailsAdapter\$PhoneViewHolder;", "context", "Landroid/content/Context;", "items", "Ljava/util/ArrayList;", "Lcom/moringa/android/g4saccesscsystem/model/Phonedetails;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getItems", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PhoneViewHolder", "G4S_Access_C_System.app"]
//)
class PhonedetailsAdapter(context: Context, items: ArrayList<*>) :
    RecyclerView.Adapter<Any?>() {
    val context: Context
    val items: ArrayList<*>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        Intrinsics.checkNotNullParameter(parent, "parent")
        val var10002 =
            PhoneLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Intrinsics.checkNotNullExpressionValue(
            var10002,
            "PhoneLayoutBinding.infla…nt.context),parent,false)"
        )
        return PhoneViewHolder(var10002)
    }

    // $FF: synthetic method
    // $FF: bridge method
    override fun onCreateViewHolder(var1: ViewGroup, var2: Int): Any {
        return this.onCreateViewHolder(var1, var2) as RecyclerView.ViewHolder?
    }

    fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        Intrinsics.checkNotNullParameter(holder, "holder")
        val var3 = holder.binding
        val var4 = false
        val var5 = false
        val var7: Int = false.toInt()
        val var10000 = items[position]
        Intrinsics.checkNotNullExpressionValue(var10000, "items[position]")
        val (image, name, office, title, destination, date, time) = var10000 as Phonedetails
        var var9 = var3.tvName
        Intrinsics.checkNotNullExpressionValue(var9, "tvName")
        var9.text = name
        var9 = var3.tvSimon
        Intrinsics.checkNotNullExpressionValue(var9, "tvSimon")
        var9.text = title
        var9 = var3.tvDate
        Intrinsics.checkNotNullExpressionValue(var9, "tvDate")
        var9.text = date
        var9 = var3.tvOffice
        Intrinsics.checkNotNullExpressionValue(var9, "tvOffice")
        var9.text = office
        var9 = var3.tvEclectics
        Intrinsics.checkNotNullExpressionValue(var9, "tvEclectics")
        var9.text = destination
        var9 = var3.tvTime
        Intrinsics.checkNotNullExpressionValue(var9, "tvTime")
        var9.text = time
        var3.Ivcall.setImageResource(image)
    }

    // $FF: synthetic method
    // $FF: bridge method
    override fun onBindViewHolder(var1: RecyclerView.ViewHolder?, var2: Int) {
        this.onBindViewHolder(var1 as PhoneViewHolder?, var2)
    }

    override fun getItemCount(): Int {
        return items.size
    }

//    @Metadata(
//        mv = [1, 4, 3],
//        bv = [1, 0, 3],
//        k = 1,
//        d1 = ["\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"],
//        d2 = ["Lcom/moringa/android/g4saccesscsystem/adapter/PhonedetailsAdapter\$PhoneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView\$ViewHolder;", "binding", "Lcom/moringa/android/g4saccesscsystem/databinding/PhoneLayoutBinding;", "(Lcom/moringa/android/g4saccesscsystem/databinding/PhoneLayoutBinding;)V", "getBinding", "()Lcom/moringa/android/g4saccesscsystem/databinding/PhoneLayoutBinding;", "G4S_Access_C_System.app"]
//    )
    class PhoneViewHolder(binding: PhoneLayoutBinding) : RecyclerView.ViewHolder() {
        val binding: PhoneLayoutBinding

        init {
            Intrinsics.checkNotNullParameter(binding, "binding")
            super(binding.root as View)
            this.binding = binding
        }
    }

    init {
        Intrinsics.checkNotNullParameter(context, "context")
        Intrinsics.checkNotNullParameter(items, "items")
        super()
        this.context = context
        this.items = items
    }
}